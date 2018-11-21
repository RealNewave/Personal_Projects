
package twitchclips.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clips",
    "_cursor"
})
public class JSONObject {

    @JsonProperty("clips")
    private List<Clip> clips = null;
    @JsonProperty("_cursor")
    private String cursor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("clips")
    public List<Clip> getClips() {
        return clips;
    }

    @JsonProperty("clips")
    public void setClips(List<Clip> clips) {
        this.clips = clips;
    }

    @JsonProperty("_cursor")
    public String getCursor() {
        return cursor;
    }

    @JsonProperty("_cursor")
    public void setCursor(String cursor) {
        this.cursor = cursor;
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
