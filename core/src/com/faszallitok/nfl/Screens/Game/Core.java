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

enum Adatok { NULL, ASEBESSEG, BSEBESSEG, SZUNYOGSEBESSEG, UT, KEZDOTAVOLSAG, REPIDO };

public class Core {
	public static float asebesseg;
	public static float bsebesseg;
	public static float szunyogsebesseg;
	public static float ut;
	public static float kezdotavolsag;

	public float szunyogpozicio;
	public float apozicio;
	public float bpozicio;
	public float tavolsag;
	public float repulttav;
	public boolean szunyogstart;

	public void CoreInit(float sa, float sb, float tavolsag, float szunyogsebesseg, float ut) {
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

	public boolean Check(Adatok adat) {
		if(adat == Adatok.NULL || adat == Adatok.REPIDO) {
			if(RepIdo() * this.szunyogsebesseg <= this.ut) return false;
		}
		return true;
	}

	public void KovIdo() {
		float idoatolbig = this.tavolsag / (this.szunyogsebesseg + (this.szunyogstart ? this.bsebesseg : this.asebesseg));

		float szunyogtavolsag = this.szunyogsebesseg * idoatolbig;
		float atavolsag = this.asebesseg * idoatolbig;
		float btavolsag = this.bsebesseg * idoatolbig;

		this.repulttav += szunyogtavolsag;
		this.apozicio += atavolsag;
		this.bpozicio -= btavolsag;
		this.szunyogstart = !this.szunyogstart;
	}

	public float RepIdo() {
		float repido = this.tavolsag / (asebesseg + bsebesseg);
		return repido;
	}
}
