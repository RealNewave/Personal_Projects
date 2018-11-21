
package twitchclips.JSONObject;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "slug",
    "tracking_id",
    "url",
    "embed_url",
    "embed_html",
    "broadcaster",
    "curator",
    "vod",
    "broadcast_id",
    "game",
    "language",
    "title",
    "views",
    "duration",
    "created_at",
    "thumbnails"
})
public class Clip {

    @JsonProperty("slug")
    private String slug;
    @JsonProperty("tracking_id")
    private String trackingId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("embed_url")
    private String embedUrl;
    @JsonProperty("embed_html")
    private String embedHtml;
    @JsonProperty("broadcaster")
    private Broadcaster broadcaster;
    @JsonProperty("curator")
    private Curator curator;
    @JsonProperty("vod")
    private Vod vod;
    @JsonProperty("broadcast_id")
    private String broadcastId;
    @JsonProperty("game")
    private String game;
    @JsonProperty("language")
    private String language;
    @JsonProperty("title")
    private String title;
    @JsonProperty("views")
    private Integer views;
    @JsonProperty("duration")
    private Double duration;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("thumbnails")
    private Thumbnails thumbnails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("tracking_id")
    public String getTrackingId() {
        return trackingId;
    }

    @JsonProperty("tracking_id")
    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("embed_url")
    public String getEmbedUrl() {
        return embedUrl;
    }

    @JsonProperty("embed_url")
    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    @JsonProperty("embed_html")
    public String getEmbedHtml() {
        return embedHtml;
    }

    @JsonProperty("embed_html")
    public void setEmbedHtml(String embedHtml) {
        this.embedHtml = embedHtml;
    }

    @JsonProperty("broadcaster")
    public Broadcaster getBroadcaster() {
        return broadcaster;
    }

    @JsonProperty("broadcaster")
    public void setBroadcaster(Broadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    @JsonProperty("curator")
    public Curator getCurator() {
        return curator;
    }

    @JsonProperty("curator")
    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    @JsonProperty("vod")
    public Vod getVod() {
        return vod;
    }

    @JsonProperty("vod")
    public void setVod(Vod vod) {
        this.vod = vod;
    }

    @JsonProperty("broadcast_id")
    public String getBroadcastId() {
        return broadcastId;
    }

    @JsonProperty("broadcast_id")
    public void setBroadcastId(String broadcastId) {
        this.broadcastId = broadcastId;
    }

    @JsonProperty("game")
    public String getGame() {
        return game;
    }

    @JsonProperty("game")
    public void setGame(String game) {
        this.game = game;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("views")
    public Integer getViews() {
        return views;
    }

    @JsonProperty("views")
    public void setViews(Integer views) {
        this.views = views;
    }

    @JsonProperty("duration")
    public Double getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("thumbnails")
    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    @JsonProperty("thumbnails")
    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
