package com.hiqo_solutions.vkclient.rest;

import com.google.gson.*;
import com.hiqo_solutions.vkclient.feed.model.attachments.*;

import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public class Rest {

    private static Rest instance;
    private VkService service;

    public static Rest getInstance() {
        if (instance == null) {
            instance = new Rest();
        }
        return instance;
    }

    private Rest() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.vk.com/method/")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(getConverter())
                .build();
        service = restAdapter.create(VkService.class);
    }

    private Converter getConverter() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Attachment.class, (JsonDeserializer<Attachment>) (json, typeOfT, context) -> {
                    JsonObject jsonObject = json.getAsJsonObject();
                    Attachment.Type type = context.deserialize(jsonObject.get("type"), Attachment.Type.class);
                    if (type == null) {
                        return new DefaultAttachment(Attachment.Type.UNDEFINED);
                    }
                    Attachment attachment = new DefaultAttachment(Attachment.Type.UNDEFINED);
                    switch (type) {
                        case PHOTO:
                            attachment = context.deserialize(jsonObject.get("photo"), AttachedPhoto.class);
                            break;
                        case POSTED_PHOTO:
                            attachment = context.deserialize(jsonObject.get("posted_photo"), PostedPhoto.class);
                            break;
                        case VIDEO:
                            attachment = context.deserialize(jsonObject.get("video"), Video.class);
                            break;
                        case AUDIO:
                            attachment = context.deserialize(jsonObject.get("audio"), Audio.class);
                            break;
                        case DOC:
                            attachment = context.deserialize(jsonObject.get("doc"), Doc.class);
                            break;
                    }
                    if (attachment != null) {
                        attachment.setType(type);
                    }
                    return attachment;

                })
                .registerTypeAdapter(Boolean.class, (JsonDeserializer<Boolean>) (json, typeOfT, context) -> {
                    JsonPrimitive primitive = json.getAsJsonPrimitive();
                    if (primitive.isBoolean()) {
                        return primitive.getAsBoolean();
                    } else if (primitive.isNumber()) {
                        return primitive.getAsInt() == 1;
                    } else if (primitive.isString()) {
                        return primitive.getAsString().equals("1");
                    }
                    return null;
                })
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return new GsonConverter(gson);
    }

    public VkService getService() {
        return service;
    }
}
