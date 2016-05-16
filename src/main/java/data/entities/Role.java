package data.entities;

public enum Role {
    PLAYER, AUTHENTICATED;

    public String roleName() {
        return "ROLE_" + this.toString();
    }

}
