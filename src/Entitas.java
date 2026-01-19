public abstract class Entitas {
    protected String id;

    public Entitas(String id) { this.id = id; }
    public abstract void tampilkanProfil(); // Override target

    public String getId() { return id; }
}