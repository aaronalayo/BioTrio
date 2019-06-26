package dk.kea.dat18i.team8.biotrio.demo.movies;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int duration;
    private String director;
    private String plot;
    private String format;
    private String sound;
    private String image;

    //empty constructor
    public Movie(){ }



    //constructor
    public Movie(int id, String title, String genre, int duration, String director, String plot, String format, String sound,String image) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.plot = plot;
        this.format = format;
        this.sound = sound;
        this.image = image;

    }

    //setters and getters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title=title;
    }

    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }

    public int getDuration(){return duration;}
    public void setDuration(int duration) {this.duration=duration;}

    public String getDirector(){return director;}
    public void setDirector(String director){this.director=director;}

    public String getFormat(){return format;}
    public void setFormat(String format){this.format=format;}

    public String getSound() { return sound; }

    public void setSound(String sound) { this.sound = sound; }

    public String getPlot(){return plot;}
    public void setPlot(String plot){this.plot=plot;}

     public String getImage() { return image;}

    public void setImage(String image) { this.image = image; }
}

