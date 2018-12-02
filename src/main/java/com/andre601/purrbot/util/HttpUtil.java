package com.andre601.purrbot.util;

import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;

public class HttpUtil {
    private static final OkHttpClient CLIENT = new OkHttpClient();

    /**
     * Gets a URL from the neko-endpoint of nekos.life
     *
     * @return The URL from the neko-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String neko() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/neko")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the ngif-endpoint of nekos.life
     *
     * @return The URL from the ngif-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String nekoAnimated() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/ngif")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the fox_girl-endpoint of nekos.life
     *
     * @return The URL from the fox_girl-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String foxgirl() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/fox_girl")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the slap-endpoint of nekos.life
     *
     * @return The URL from the slap-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String slap() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/slap")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the hug-endpoint of nekos.life
     *
     * @return The URL from the hug-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String hug() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/hug")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the pat-endpoint of nekos.life
     *
     * @return The URL from the pat-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String pat() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/pat")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the cuddle-endpoint of nekos.life
     *
     * @return The URL from the cuddle-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String cuddle() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/cuddle")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the tickle-endpoint of nekos.life
     *
     * @return The URL from the tickle-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String tickle() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/tickle")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code" + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the kiss-endpoint of nekos.life
     *
     * @return The URL from the kiss-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String kiss() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/kiss")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the poke-endpoint of nekos.life
     *
     * @return The URL from the poke-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String poke() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/poke")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the gecg-endpoint of nekos.life
     *
     * @return The URL from the gecg-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String gecg() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/gecg")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the lewd-endpoint of nekos.life
     *
     * @return The URL from the lewd-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String lewd() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/lewd")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the nsfw_neko_gif-endpoint of nekos.life
     *
     * @return The URL from the nsfw_neko_gif-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String lewdAnimated() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/nsfw_neko_gif")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the les-endpoint of nekos.life
     *
     * @return The URL from the les-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String lesbian() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/les")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets a URL from the classic-endpoint of nekos.life
     *
     * @return The URL from the classic-endpoint.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static String fuck() throws Exception{
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/classic")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string()).get("url").toString();
        }
    }

    /**
     * Gets the JSON from the bot-page.
     *
     * @return A JSONObject with info of the bot-page.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static JSONObject voteInfo() throws Exception{
        Request request = new Request.Builder()
                .url("https://discordbots.org/api/bots/425382319449309197")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string());
        }
    }

    /**
     * Gets a JSON object from the whatthecommit site.
     *
     * @return A JSONObject with info.
     * @throws Exception
     *         Thrown when for example the site is unavailable.
     */
    private static JSONObject fakeGit() throws Exception{
        Request request = new Request.Builder()
                .url("http://whatthecommit.com/index.json")
                .build();
        Response response = CLIENT.newCall(request).execute();
        try(ResponseBody responseBody = response.body()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return new JSONObject(Objects.requireNonNull(responseBody).string());
        }
    }

    /**
     * Gets content of a provided link as String.
     *
     * @param  request
     *         The link to get the content from.
     *
     * @return The content of the site as a String.
     */
    public static String requestHttp(String request){
        try{
            return IOUtils.toString(new URL(request), Charset.forName("UTF-8"));
        }catch (IOException ignored){
            return "";
        }
    }

    /**
     * Getter for {@link #neko()}.
     *
     * @return possible-null String
     */
    public static String getNeko(){
        try{
            return neko();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #nekoAnimated()}.
     *
     * @return possible-null String
     */
    public static String getNekoAnimated(){
        try{
            return nekoAnimated();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #foxgirl()}.
     *
     * @return possible-null String
     */
    public static String getFoxgirl(){
        try {
            return foxgirl();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #hug()}.
     *
     * @return possible-null String
     */
    public static String getHug(){
        try{
            return hug();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #slap()}.
     *
     * @return possible-null String
     */
    public static String getSlap(){
        try{
            return slap();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #pat()}.
     *
     * @return possible-null String
     */
    public static String getPat(){
        try{
            return pat();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #cuddle()}.
     *
     * @return possible-null String
     */
    public static String getCuddle(){
        try{
            return cuddle();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #kiss()}.
     *
     * @return possible-null String
     */
    public static String getKiss(){
        try{
            return kiss();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #tickle()}.
     *
     * @return possible-null String
     */
    public static String getTickle(){
        try{
            return tickle();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #poke()}.
     *
     * @return possible-null String
     */
    public static String getPoke(){
        try{
            return poke();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #gecg()}.
     *
     * @return possible-null String
     */
    public static String getGecg(){
        try{
            return gecg();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #lewd()}.
     *
     * @return possible-null String
     */
    public static String getLewd(){
        try{
            return lewd();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #lewdAnimated()}.
     *
     * @return possible-null String
     */
    public static String getLewdAnimated(){
        try {
            return lewdAnimated();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #lesbian()}.
     *
     * @return possible-null String
     */
    public static String getLesbian(){
        try {
            return lesbian();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #fuck()}.
     *
     * @return possible-null String
     */
    public static String getFuck(){
        try{
            return fuck();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #voteInfo()}.
     *
     * @return possible-null JSONObject
     */
    public static JSONObject getVoteInfo(){
        try{
            return voteInfo();
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Getter for {@link #fakeGit()}.
     *
     * @return possible-null JSONObject
     */
    public static JSONObject getFakeGit(){
        try{
            return fakeGit();
        }catch (Exception ex){
            return null;
        }
    }
}
