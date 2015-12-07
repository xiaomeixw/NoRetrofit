# NoRetrofit
Deconstruct retrofit demo for my blog 's article


# Screen
<img src="http://i.imgur.com/PiZWDZl.png" width="45%">

# Use OKHttp in Android

	final OkHttpClient okHttpClient = new OkHttpClient();

    final com.squareup.okhttp.Request trueRequest = new com.squareup.okhttp.Request.Builder()
                .url("http://www.mlm.com/v6/tehui/getNewTehuiDetailById?t_id=2500&signapp=1245212354755112")
                .build();


     okHttpClient.newCall(trueRequest).enqueue(new Callback() {
          @Override
          public void onFailure(Request request, IOException e) {

          }

          @Override
          public void onResponse(Response response) throws IOException {
                   String responseUrl = response.body().string();
                   //RetrofitLog.i("responseUrl="+responseUrl);
           }
     });

The code smell so good but we can Encapsulates OkHttp  in Retrofit.

# NoRetrofit Usage
1.NoRetrofit turns your HTTP API into a Java interface.

	@RetrofitAPI
	public interface SnakeService {
	
	
	    @GET("/tehui/getNewTehuiDetailById")
	    JsonBean<Bean> getBean(@QueryMap Map<String, String> coordinates);
	
	    @GET("/user/{id}")
	    String getUser(@Path("id") String id);
	
	    @POST("/user/signin")
	    UserInfo getLogin(@Field("username") String username, @Field("password") String password);
	
	
	    @GET("/tehui/getNewTehuiDetailById")
	    JsonBean<Bean> getHeader(@QueryMap Map<String, String> coordinates,@Header("Content-Type") String head);
	
	
	    @GET("/tehui/getNewTehuiDetailById")
	    JsonBean<Bean> getQuery(@Query("t_id") String t_id,@Query("signapp") String sign_app);
	}


2.The NoRetrofit class generates an implementation of the SnakeService interface.

 	SnakeService snakeService = NoRetrofit.create("http://www.mlm.com", SnakeService.class);

3.Each Call from the created SnakeService can make a asynchronous HTTP request to the remote webserver.

	HashMap<String, String> map = new HashMap<>();
    map.put("t_id","2500");
    map.put("signapp", "signapp");
    JsonBean<Bean> bean = snakeService.getBean(map);

#License

Copyright 2015 xiaomeixw

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
