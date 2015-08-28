package com.hiqo_solutions.vkclient.rest;

import com.hiqo_solutions.vkclient.feed.model.Response;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;


/**
 * Created by dmitry.zheltko on 8/6/2015.
 */
public interface VkService {
    @GET("/newsfeed.get")
    Observable<Response> newsFirst(@Query("access_token") String accessToken,
                                   @Query("filters") String filters,
                                   @Query("return_banned") Integer returnBanned,
                                   //   @Query("start_time") Long startTime,
                                   //   @Query("end_time") Long endTime,
                                   @Query("max_photos") Integer maxPhotos,
                                   //  @Query("start_from") Long startFrom,
                                   @Query("count") Long count,
                                   @Query("v") String version);

    @GET("/newsfeed.get")
    Observable<Response> uploadMoreNews(@Query("access_token") String accessToken,
                                        @Query("filters") String filters,
                                        @Query("return_banned") Integer returnBanned,
//                                 @Query("start_time") Long startTime,
                                        //   @Query("end_time") Long endTime,
                                        @Query("max_photos") Integer maxPhotos,
                                        @Query("start_from") String startFrom,
                                        @Query("count") Long count,
                                        @Query("v") String version);

    @GET("/newsfeed.get")
    Observable<Response> updateNews(@Query("access_token") String accessToken,
                                    @Query("filters") String filters,
                                    @Query("return_banned") Integer returnBanned,
                                    @Query("start_time") Long startTime,
//                                    @Query("end_time") Long endTime,
                                    @Query("max_photos") Integer maxPhotos,
                                    //  @Query("start_from") Long startFrom,
                                    @Query("count") Long count,
                                    @Query("v") String version);
}
