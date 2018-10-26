package com.faszallitok.nfl.Screens.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.nfl.GlobalClasses.Assets;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.nfl.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.nfl.MyBaseClasses.UI.MyButton;
import com.faszallitok.nfl.MyGdxGame;

public class Core {
	public static float asebesseg;
	public static float bsebesseg;
	public static float szunyogsebesseg;
	public static float ut;
	public static float kezdotavolsag;
	public static float repido;

	public static float szunyogpozicio;
	public static float apozicio;
	public static float bpozicio;

	public enum Adatok { NULL, ASEBESSEG, BSEBESSEG, SZUNYOGSEBESSEG, UT, KEZDOTAVOLSAG, REPIDO } hianyzoadat;

	public static void CoreInit(float sa, float sb, float tavolsag, float szunyogsebesseg, float ut, float repido) {
		this.asebesseg = sa;
		this.bsebesseg = sb;
		this.kezdotavolsag = tavolsag;
		this.ut = ut;
		this.repido = repido;
		this.szunyogsebesseg = szunyogsebesseg;
		this.hianyzoadat = hianyzoadat;

		this.szunyogpozicio = 0;
		this.apozicio = 0;
		this.bpozicio = tavolsag;
	}

	public static boolean Check(enum Adatok adat, enum Adatok hianyzoadat) {
		return true;
	}

	public static float KovIdo() {
		
	}

	public static float RepIdo() {
		float repido = (sa + sb) / tavolsag;
		return repido;
	}
}
