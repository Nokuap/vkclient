package com.hiqo_solutions.vkclient.feed;

import android.os.Bundle;
import android.support.design.widget.*;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;

import com.hiqo_solutions.vkclient.R;
import com.hiqo_solutions.vkclient.feed.model.NewsAdapter;
import com.hiqo_solutions.vkclient.feed.model.Response;
import com.hiqo_solutions.vkclient.rest.Rest;
import com.hiqo_solutions.vkclient.utils.Prefs;
import com.hiqo_solutions.vkclient.utils.Utils;
import com.orhanobut.hawk.Hawk;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@SuppressWarnings("ConstantConditions")
public class FeedActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view) RecyclerView recyclerView;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.app_bar) AppBarLayout appBar;
    @Bind(R.id.btnCreate) FloatingActionButton btnCreate;
    @Bind(R.id.content) CoordinatorLayout content;
    @Bind(R.id.navigation) NavigationView navigation;
    @Bind(R.id.drawer) DrawerLayout drawer;
    @Bind(R.id.refresher) SwipeRefreshLayout refresher;

    private NewsAdapter newsAdapter;
    LinearLayoutManager layoutManager;

    private Long lastLoadTime;
    private String lastLoadMoreTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> drawer.openDrawer(Gravity.LEFT));
        initRecycler();
        uploadNews();
        refresher.setOnRefreshListener(this::updateNews);
    }

    private void initRecycler() {
        newsAdapter = new NewsAdapter();
        recyclerView.setAdapter(newsAdapter);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();

                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                    uploadMoreNews();
                }

            }
        });
    }

    private void updateNews() {
        long currentTimeMillis = System.currentTimeMillis();
        Rest.getInstance().getService().updateNews(Hawk.get(Prefs.TOKEN), "post", 1, lastLoadTime / 1000, 10, 5l, "5.36")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    newsAdapter.addNews(response.getNews(), NewsAdapter.START);
                    refresher.setRefreshing(false);
                }, this::handleError);
        lastLoadTime = currentTimeMillis;
    }

    private void uploadNews() {
        refresher.setRefreshing(true);
        lastLoadTime = System.currentTimeMillis();
        Observable<Response> uploadNews = ObserverHandler.getUploadNews();
        uploadNews.subscribe(response -> {
            newsAdapter.addNews(response.getNews(), NewsAdapter.START);
            Hawk.put(Prefs.LOAD_FROM, response.getNews().getNextFrom());
            refresher.setRefreshing(false);
        }, this::handleError);
    }

    private void uploadMoreNews() {
        refresher.setRefreshing(true);
        String currentLoadMoreTime = Hawk.get(Prefs.LOAD_FROM);
        if (currentLoadMoreTime != null && !currentLoadMoreTime.equals(lastLoadMoreTime)) {
            refresher.setRefreshing(true);
            lastLoadMoreTime = currentLoadMoreTime;
            Rest.getInstance().getService().uploadMoreNews(Hawk.get(Prefs.TOKEN), "post", 1, 10, currentLoadMoreTime, 5l, "5.36")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        newsAdapter.addNews(response.getNews(), NewsAdapter.END);
                        Hawk.put(Prefs.LOAD_FROM, response.getNews().getNextFrom());
                        refresher.setRefreshing(false);
                    }, this::handleError);
        }
    }

    private void handleError(Throwable error) {
        refresher.setRefreshing(false);
        Utils.toast(error.getMessage());
        error.printStackTrace();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObserverHandler.unbind();
    }

    static final class ObserverHandler {
        private static rx.Observable<Response> uploadNews;

        public static rx.Observable<Response> getUploadNews() {
            if (uploadNews == null) {
                uploadNews = Rest.getInstance().getService().newsFirst(Hawk.get(Prefs.TOKEN), "post", 1, 10, 100l, "5.36")
                        .subscribeOn(Schedulers.newThread())
                        .cache()
                        .observeOn(AndroidSchedulers.mainThread());
            }
            return uploadNews;
        }

        public static void unbind() {
            if (uploadNews != null) {
                Utils.log();
                uploadNews.unsubscribeOn(AndroidSchedulers.mainThread());
            }
        }
    }
}
