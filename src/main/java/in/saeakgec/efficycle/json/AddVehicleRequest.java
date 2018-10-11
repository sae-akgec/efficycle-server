package in.saeakgec.efficycle.json;

import javax.validation.constraints.NotBlank;

public class AddVehicleRequest {
    private long vehicle_id;

    @NotBlank
    private String user_id;

    private boolean isAdmin;

    public AddVehicleRequest() {
    }

    public long getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
