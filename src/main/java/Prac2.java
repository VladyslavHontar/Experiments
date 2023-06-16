class Publication {

  private String title;

  public Publication(String title) {
    this.title = title;
  }

  public String getDetails() {
    return "title=\"" + title + "\"";
  }

}

class Newspaper extends Publication {

  private String source;

  public Newspaper(String title, String source) {
    super(title);
    this.source = source;
  }

  @Override
  public String getDetails() {
    String title = super.getDetails();
    return "title=\"" + title +  ", source=" + source + "\"";
  }

}