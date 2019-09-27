public class Note {
    private String text;
    private String date;

    public void setText(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }


    public Note(String text) {
        this.text = text;

    }
}
