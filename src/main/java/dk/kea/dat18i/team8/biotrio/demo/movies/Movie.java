package dk.kea.dat18i.team8.biotrio.demo.movies;

import dk.kea.dat18i.team8.biotrio.demo.theater.Theater;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int duration;
    private String director;
    private String plot;
    private String format;
    //private Theater theater;
    private int theater_id;

    public Movie(){ }

    public Movie(int id, String title, String genre, int duration, String director, String plot, String format, int theater_id) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.plot = plot;
        this.format = format;
        this.theater_id=theater_id;
        //this.theater_id = theater_id;
    }

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

    public int getTheater_id(){return theater_id;}
    public void setTheater_id(int theater_id){this.theater_id=theater_id;}

    public String getPlot(){return plot;}
    public void setPlot(String plot){this.plot=plot;}

}
