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
		this.scrarany = this.scrkezdotavolsag / this.kezdotavolsag;
		this.ido = 0;
		this.kovetkezo = 0;

		System.out.println("========= Core start ==========");
		System.out.println("a sebesség: " + this.asebesseg);
		System.out.println("b sebesség: " + this.bsebesseg);
		System.out.println("sz sebesség: " + this.szunyogsebesseg);
		System.out.println("A-B táv: " + this.kezdotavolsag);
		System.out.println("Repülni kívánt táv: " + this.ut);
		System.out.println("===============================");
	}

	public boolean Frame(float delta) {
		this.ido += delta;

		this.ax += this.scrarany * this.asebesseg * delta;
		this.bx -= this.scrarany * this.bsebesseg * delta;
		this.szunyogx += (this.szunyogstart ? -1 : 1) * delta * this.szunyogsebesseg * this.scrarany;

		if(this.ido >= this.kovetkezo) {
			System.out.println("Kovido");
			KovIdo();
		}

		if(this.repulttav >= this.ut) {
			System.out.println("Távolság átlépve, kilépés az A ember elérésekor");
			//A szúnyog megtette az utat, screen váltás
		}

		if(this.ax >= this.bx) {
			// hmmm... ha ez lefut, akkor gond van...
			System.out.println("Igen, ez egy bug XD");
			System.out.println(this.ax + " | " + this.bx);
			System.exit(1);
		}

		return true;
	}

	public boolean Check() {
		if(RepIdo() * this.szunyogsebesseg <= this.ut) return false;
		return true;
	}

	public void KovIdo() {
		float idoatolbig = this.tavolsag / (this.szunyogsebesseg + (this.szunyogstart ? this.bsebesseg : this.asebesseg));
		System.out.println("Kovetkezo valtas: " + idoatolbig);

		float szunyogtavolsag = this.szunyogsebesseg * idoatolbig;
		float atavolsag = this.asebesseg * idoatolbig;
		float btavolsag = this.bsebesseg * idoatolbig;

		this.repulttav += szunyogtavolsag;
		this.apozicio += atavolsag;
		this.bpozicio -= btavolsag;
		this.szunyogstart = !this.szunyogstart;
		this.kovetkezo += idoatolbig;
		this.tavolsag -= (this.asebesseg + this.bsebesseg) * idoatolbig;

		if(this.repulttav >= this.ut && !this.szunyogstart) {
			System.out.println("Vége, repült idö: " + this.ido);
			System.exit(1);
		}
	}

	public float RepIdo() {
		float repido = this.tavolsag / (asebesseg + bsebesseg);
		return repido;
	}
}
