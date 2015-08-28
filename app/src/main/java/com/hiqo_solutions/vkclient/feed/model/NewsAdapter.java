package com.hiqo_solutions.vkclient.feed.model;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.annimon.stream.Collectors;
import com.annimon.stream.Optional;
import com.annimon.stream.Stream;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hiqo_solutions.vkclient.App;
import com.hiqo_solutions.vkclient.R;
import com.hiqo_solutions.vkclient.feed.model.attachments.AttachedPhoto;
import com.hiqo_solutions.vkclient.feed.model.attachments.Attachment;
import com.hiqo_solutions.vkclient.feed.model.attachments.Video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.*;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

import static android.widget.GridLayout.ALIGN_BOUNDS;
import static android.widget.GridLayout.HORIZONTAL;
import static android.widget.GridLayout.spec;

/**
 * Created by dmitry.zheltko on 8/7/2015.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    @IntDef({START, END})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Place {
    }

    public static final int START = 0;
    public static final int END = 1;

    List<Post> posts = new LinkedList<>();
    Set<Profile> profiles = new HashSet<>();
    Set<Group> groups = new HashSet<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(App.getContext()).inflate(R.layout.feed_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Timber.d(String.valueOf(position));
        Post post = posts.get(position);

        holder.attachmentsContainer.removeAllViews();

        if (post.getSourceId() > 0) {
            Optional<Profile> profileOptional = Stream.of(profiles).filter(profile -> post.getSourceId().equals(profile.getId())).findFirst();
            if (profileOptional.isPresent()) {
                Profile profile = profileOptional.get();
                Glide.with(App.getContext()).load(profile.getPhoto_50()).diskCacheStrategy(DiskCacheStrategy.ALL).dontTransform().into(holder.loaderImage);
                holder.loaderName.setText(profile.getFirstName() + " " + profile.getLastName());
            }
        } else {
            Optional<Group> groupOptional = Stream.of(groups).filter(group -> post.getSourceId().equals(-group.getId())).findFirst();
            if (groupOptional.isPresent()) {
                Group group = groupOptional.get();
                Glide.with(App.getContext()).load(group.getPhoto_50()).diskCacheStrategy(DiskCacheStrategy.ALL).dontTransform().into(holder.loaderImage);
                holder.loaderName.setText(group.getName());
            }
        }

        holder.date.setText(SimpleDateFormat.getInstance().format(new Date(post.getDate() * 1000)));
        if (post.getComments() != null && post.getComments().getCanPost()) {
            holder.comments.setText("COMMENTS " + post.getComments().getCount());
        }
        if (post.getLikes() != null && post.getLikes().getCanLike()) {
            holder.likes.setText(post.getLikes().getCount().toString());
        }
        if (post.getReposts() != null) {
            holder.reposts.setText(post.getReposts().getCount().toString());
        }


        if (post.getText() != null) {
            TextView text = new TextView(App.getContext());
            text.setTextColor(App.getContext().getResources().getColor(R.color.primary_text));
            text.setText(post.getText());
            holder.attachmentsContainer.addView(text);
        }

        if (post.getAttachments() != null) {

            List<AttachedPhoto> photos = Stream.of(post.getAttachments())
                    .filter(attachment -> Attachment.Type.PHOTO.equals(attachment.getType()))
                    .map(attachment -> (AttachedPhoto) attachment)
                    .collect(Collectors.toList());
            if (photos.size() > 0) {
                if (photos.size() == 1) {
                    ImageView image = new ImageView(App.getContext());
                    Glide.with(App.getContext()).load(photos.get(0).getPhoto_807()).diskCacheStrategy(DiskCacheStrategy.ALL).dontTransform().into(image);
                    holder.attachmentsContainer.addView(image);
                } else {
                    GridLayout photoLayout = getGridLayout();
                    holder.attachmentsContainer.addView(photoLayout);
                    for (AttachedPhoto photo : photos) {
                        ImageView image = new ImageView(App.getContext());
                        Glide.with(App.getContext()).load(photo.getPhoto_130()).diskCacheStrategy(DiskCacheStrategy.ALL).dontTransform().into(image);
                        photoLayout.addView(image, new GridLayout.LayoutParams(spec(photoLayout.getChildCount() / 4), spec(photoLayout.getChildCount() % 4)));
                    }
                }
            }

            List<Video> videos = Stream.of(post.getAttachments())
                    .filter(attachment -> Attachment.Type.VIDEO.equals(attachment.getType()))
                    .map(attachment -> (Video) attachment)
                    .collect(Collectors.toList());
            if (videos.size() > 0) {
                if (videos.size() == 1) {
                    ImageView video = new ImageView(App.getContext());
                    Glide.with(App.getContext()).load(videos.get(0).getPhoto_640()).diskCacheStrategy(DiskCacheStrategy.ALL).dontTransform().into(video);
                    holder.attachmentsContainer.addView(video);
                } else {
                    GridLayout videoLayout = getGridLayout();
                    holder.attachmentsContainer.addView(videoLayout);
                    for (Video video : videos) {
                        ImageView image = new ImageView(App.getContext());
                        Glide.with(App.getContext()).load(video.getPhoto_130()).diskCacheStrategy(DiskCacheStrategy.ALL).dontTransform().into(image);
                        videoLayout.addView(image, new GridLayout.LayoutParams(spec(videoLayout.getChildCount() / 4), spec(videoLayout.getChildCount() % 4)));
                    }
                }
            }

        }


//        if (post.getPhotos() != null && post.getPhotos().getCount() > 0) {
//            List<Photo> photos = post.getPhotos().getItems();
//            Timber.d("got photos" + photos);
//            GridLayout layout = getGridLayout();
//            int i = 0;
//            for (Photo photo : photos) {
//                ImageView image = new ImageView(App.getContext());
//                Glide.with(App.getContext()).load(photo.getPhoto_130()).dontTransform().into(image);
//                layout.addView(image, new GridLayout.LayoutParams(spec(i / 4), spec(i % 4)));
//                i++;
//            }
//            holder.attachmentsContainer.addView(layout);
//        }


    }

    @NonNull
    private GridLayout getGridLayout() {
        GridLayout layout = new GridLayout(App.getContext());
        layout.setColumnCount(4);
        layout.setOrientation(HORIZONTAL);
        layout.setUseDefaultMargins(true);
        layout.setAlignmentMode(ALIGN_BOUNDS);
        layout.setRowOrderPreserved(false);
        return layout;
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void addNews(News news, @Place int place) {
        if (news.getPosts().size() == 0) {
            return;
        }
        switch (place) {
            case START:
                posts.addAll(0, news.getPosts());
                break;
            case END:
                posts.addAll(news.getPosts());
                break;
        }
        groups.addAll(news.getGroups());
        profiles.addAll(news.getProfiles());
        notifyDataSetChanged();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.loader_image) ImageView loaderImage;
        @Bind(R.id.loader_name) TextView loaderName;
        @Bind(R.id.attachments_container) LinearLayout attachmentsContainer;
        @Bind(R.id.comments) TextView comments;
        @Bind(R.id.reposts) TextView reposts;
        @Bind(R.id.likes) TextView likes;
        @Bind(R.id.date) TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            date.setVisibility(View.VISIBLE);
        }
    }


}
