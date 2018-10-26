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
	public float asebesseg;
	public float bsebesseg;
	public float szunyogsebesseg;
	public float ut;
	public float kezdotavolsag;
	public int scrwidth;
	public int scrheight;
	public int ax;
	public int bx;
	public int szunyogx;

	public float szunyogpozicio;
	public float apozicio;
	public float bpozicio;
	public float tavolsag;
	public float repulttav;
	public boolean szunyogstart;
	public int scrkezdotavolsag;
	public float scrarany;
	public float ido;
	public float kovetkezo;

	public void Core() {};

	public void CoreInit(float sa, float sb, float tavolsag, float szunyogsebesseg, float ut, int w, int h, int ax, int bx, int szunyogx) {
		this.asebesseg = sa;
		this.bsebesseg = sb;
		this.kezdotavolsag = tavolsag;
		this.ut = ut;
		this.szunyogsebesseg = szunyogsebesseg;
		this.scrwidth = w;
		this.scrheight = h;
		this.ax = ax;
		this.bx = bx;
		this.szunyogx = this.ax;

		CoreReset();
	}

	public void CoreReset() {
		this.szunyogpozicio = 0;
		this.apozicio = 0;
		this.bpozicio = this.kezdotavolsag;
		this.tavolsag = this.kezdotavolsag;
		this.repulttav = 0;
		this.szunyogstart = true;
		this.scrkezdotavolsag = this.bx - this.ax;
		this.scrarany = this.kezdotavolsag / this.scrkezdotavolsag;
		this.ido = 0;
		this.kovetkezo = 0;
	}

	public boolean Frame(float delta) {
		this.ido += delta;
		float scradelta = this.scrarany * 
		this.ax += scradelta;

		if(this.ido >= this.kovetkezo) {
			//KovIdo();
		}

		if(this.repulttav >= this.ut) {
			//A szúnyog megtette az utat, screen váltás
		}

		return true;
	}

	public boolean Check() {
		if(RepIdo() * this.szunyogsebesseg <= this.ut) return false;
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
		this.kovetkezo += idoatolbig;
	}

	public float RepIdo() {
		float repido = this.tavolsag / (asebesseg + bsebesseg);
		return repido;
	}
}
