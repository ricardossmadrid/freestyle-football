package data.entities;

public enum Role {
    PLAYER, AUTHENTICATED, ADMIN;

    public String roleName() {
        return "ROLE_" + this.toString();
    }

}
