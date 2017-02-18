package by.sysadmins.dashboard.dto;

import java.util.Map;

public class InboundRouteDto {

    private String description;
    private String prefix;
    private String destination;
    private String destinationType;
    private Map<String, String> options;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(String destinationType) {
        this.destinationType = destinationType;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InboundRouteDto that = (InboundRouteDto) o;

        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (prefix != null ? !prefix.equals(that.prefix) : that.prefix != null) return false;
        if (!destination.equals(that.destination)) return false;
        return (destinationType != null ? destinationType.equals(that.destinationType) : that.destinationType == null)
                && (options != null ? options.equals(that.options) : that.options == null);

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
        result = 31 * result + destination.hashCode();
        result = 31 * result + (destinationType != null ? destinationType.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }
}
