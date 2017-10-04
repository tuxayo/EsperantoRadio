package dk.dr.radio.data;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dk.dk.niclas.models.MestSete;

/**
 * Created by j on 27-02-17.
 */

public abstract class Backend {
  public List<Kanal> kanaler = new ArrayList<>();

  protected abstract void ikkeImplementeret();
  protected void _ikkeImplementeret() {
    Exception x = new Exception("Ikke implementeret i " + getClass().getName());
    StackTraceElement[] ss = x.getStackTrace();
    System.err.println(x);
    for (int i=1; i<5; i++)
      System.err.println("\tat " + ss[i]);
  }

  public abstract String getGrunddataUrl();

  public abstract InputStream getLokaleGrunddata(Context ctx);


  public abstract void initGrunddata(final Grunddata grunddata, String grunddataStr) throws JSONException, IOException;

  public String getNyeProgrammerSiden(String programserieSlug, String dato) {
    ikkeImplementeret();
    return null;
  }

  public Programserie parsProgramserie(JSONObject programserieJson, Programserie programserie) throws JSONException{
    ikkeImplementeret();
    return programserie;
  }

  public String getAlleProgramserierAtilÅUrl() {
    ikkeImplementeret();
    return null;
  }

  public String getBogOgDramaUrl() {
    ikkeImplementeret();
    return null;
  }

  public Udsendelse parseUdsendelse(Kanal kanal, Programdata data, JSONObject udsendelseJson) throws JSONException {
    ikkeImplementeret();
    return null;
  }

  public String getProgramserieUrl(Programserie programserie, String programserieSlug, int offset) {
    ikkeImplementeret();
    return null;
  }

  public ArrayList<Udsendelse> parseUdsendelserForProgramserie(JSONArray jsonArray, Kanal kanal, Programdata data) throws JSONException {
    ikkeImplementeret();
    return null;
  }

  public String getUdsendelserPåKanalUrl(Kanal kanal, String datoStr) {
    ikkeImplementeret();
    return null;
  }

  public String getPlaylisteUrl(Udsendelse udsendelse) {
    ikkeImplementeret();
    return null;
  }

  public ArrayList<Playlisteelement> parsePlayliste(Udsendelse udsendelse, JSONArray jsonArray) throws JSONException {
    ikkeImplementeret();
    return null;
  }

  public String getUdsendelseUrlFraSlug(String udsendelseSlug) {
    ikkeImplementeret();
    return null;
  }

  public ArrayList<Udsendelse> parseUdsendelserForKanal(String jsonStr, Kanal kanal, Date dato, Programdata data) throws JSONException {
    ikkeImplementeret();
    return null;
  }

  public ArrayList<Indslaglisteelement> parsIndslag(JSONObject jsonObj) throws JSONException {
    ikkeImplementeret();
    return null;
  }


  public String getKanalStreamsUrl(Kanal kanal) {
    ikkeImplementeret();
    return null;
  }

  public String getUdsendelseStreamsUrl(Udsendelse udsendelse) {
    ikkeImplementeret();
    return null;
  }

  public ArrayList<Lydstream> parsStreams(JSONObject jsonobj) throws JSONException {
    ikkeImplementeret();
    return null;
  }

  public void parseNowNextAlleKanaler(String json, Grunddata grunddata) throws JSONException {
    ikkeImplementeret();
  }

  public MestSete parseMestSete(MestSete mestSete, Programdata data, String json, String kanalSlug) throws JSONException {
    ikkeImplementeret();
    return null;
  }

  public ArrayList<Udsendelse> parseNowNextKanal(JSONObject jsonObject, Kanal kanal) throws JSONException {
    ikkeImplementeret();
    return null;
  }
}
