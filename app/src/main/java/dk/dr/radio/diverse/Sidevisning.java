package dk.dr.radio.diverse;

import android.content.Intent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import dk.dr.radio.akt.Afspiller_frag;
import dk.dr.radio.akt.AlleUdsendelserAtilAA_frag;
import dk.dr.radio.akt.DramaOgBog_frag;
import dk.dr.radio.akt.FangBrowseRadioIntent_akt;
import dk.dr.radio.akt.Favoritprogrammer_frag;
import dk.dr.radio.akt.Hentede_udsendelser_frag;

// import com.gemius.sdk.MobilePlugin; // EO ŝanĝo

/**
 * Created by j on 28-11-14.
 */
public class Sidevisning {
  private static final HashMap<Class, String> m = new HashMap<Class, String>();

  private static Sidevisning instans = null;
  public static Sidevisning i() {
    if (instans==null) {
      instans = new Sidevisning();
    }
    return instans;
  }

  public static final String DEL = "del_udsendelse";
  public static final String KONTAKT_SKRIV = "kontakt__skriv_meddelelse";

  static {
    m.put(Afspiller_frag.class, "afspiller_popop");
    m.put(AlleUdsendelserAtilAA_frag.class, "alle_udsendelser");
    m.put(DramaOgBog_frag.class, "drama_og_bog");
    m.put(FangBrowseRadioIntent_akt.class, "fang_browser");
    m.put(Favoritprogrammer_frag.class, "favoritter");
    m.put(Hentede_udsendelser_frag.class, "hentede_udsendelser");
  }
  private final static HashSet<String> besøgt = new HashSet<String>();
  private static Intent intent;

  public void vist(String side, String slug) {
    //if (!App.PRODUKTION) App.kortToast("vist "+side+" "+slug);
    besøgt.add(side);

  }


  public static void vist(Class fk, String slug) {
    String side = m.get(fk);
    if (side==null) {
      side = fk.getSimpleName();
      m.put(fk, side);
    }
    i().vist(side, slug);
  }

  public static void vist(Class fk) {
    vist(fk, null);
  }

  public static void vist(String side) {
    i().vist(side, null);
  }

  /** Giver sorteret af viste sider, som en streng */
  public static String getViste() {
    return new TreeSet<String>(besøgt).toString();
  }

  /** Giver sorteret af ikke-viste sider, som en streng */
  public static String getIkkeViste() {
    TreeSet<String> ejBesøgt = new TreeSet<String>(m.values());
    ejBesøgt.removeAll(besøgt);
    return ejBesøgt.toString();
  }


  public void synlig(boolean synligNu) {
    if (App.fejlsøgning) App.kortToast("synligNu = "+synligNu);
  }
}
