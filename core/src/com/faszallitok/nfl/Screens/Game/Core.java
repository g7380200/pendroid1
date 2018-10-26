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

public enum Adatok { NULL, ASEBESSEG, BSEBESSEG, SZUNYOGSEBESSEG, UT, KEZDOTAVOLSAG, REPIDO };

public class Core {
    /*
	public static float asebesseg;
	public static float bsebesseg;
	public static float szunyogsebesseg;
	public static float ut;
	public static float kezdotavolsag;

	public static float szunyogpozicio;
	public static float apozicio;
	public static float bpozicio;
	public static float tavolsag;
	public static float repulttav;
	public static boolean szunyogstart;

	public static void CoreInit(float sa, float sb, float tavolsag, float szunyogsebesseg, float ut) {
		this.asebesseg = sa;
		this.bsebesseg = sb;
		this.kezdotavolsag = tavolsag;
		this.ut = ut;
		this.szunyogsebesseg = szunyogsebesseg;

		this.szunyogpozicio = 0;
		this.apozicio = 0;
		this.bpozicio = tavolsag;
		this.tavolsag = tavolsag;
		this.repulttav = 0;
		this.szunyogstart = true;
	}

	public static boolean Check(Adatok adat) {
		if(adat == Adatok.NULL || adat == Adatok.REPIDO) {
			if(RepIdo() * this.szunyogsebesseg <= this.ut) return false;
		}
		return true;
	}

	public static void KovIdo() {
		float idoatolbig = this.tavolsag / (this.szunyogsebesseg + (this.szunyogstart ? this.bsebesseg : this.asebesseg));

		float szunyogtavolsag = this.szunyogsebesseg * idoatolbig;
		float atavolsag = this.asebesseg * idoatolbig;
		float btavolsag = this.bsebesseg * idoatolbig;

		this.repulttav += szunyogtavolsag;
		this.apozicio += atavolsag;
		this.bpozicio -= btavolsag;
		this.szunyogstart = !this.szunyogstart;
	}

	public static float RepIdo() {
		float repido = this.tavolsag / (asebesseg + bsebesseg);
		return repido;
	}*/
}
