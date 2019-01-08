package in.sashi.sporteco.models.coach;

import com.google.gson.annotations.SerializedName;

public class Coach {

    private String status;
    private String message;

    @SerializedName("coach_details")
    private CoachDetails coachDetails;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CoachDetails getCoachDetails() {
        return coachDetails;
    }

    public void setCoachDetails(CoachDetails coachDetails) {
        this.coachDetails = coachDetails;
    }
}
