package com.music.entity;

public class Music {
	private Integer music_id;
	private String music_name;
	private String music_url;
	private String music_img;
	private int play_count;
	public Music() {
		super();
	}
	public Music(String music_name, String music_url, String music_img, int play_count) {
		super();
		this.music_name = music_name;
		this.music_url = music_url;
		this.music_img = music_img;
		this.play_count = play_count;
	}
	public Music(Integer music_id, String music_name, String music_url, String music_img, int play_count) {
		super();
		this.music_id = music_id;
		this.music_name = music_name;
		this.music_url = music_url;
		this.music_img = music_img;
		this.play_count = play_count;
	}
	public Integer getMusic_id() {
		return music_id;
	}
	public void setMusic_id(Integer music_id) {
		this.music_id = music_id;
	}
	public String getMusic_name() {
		return music_name;
	}
	public void setMusic_name(String music_name) {
		this.music_name = music_name;
	}
	public String getMusic_url() {
		return music_url;
	}
	public void setMusic_url(String music_url) {
		this.music_url = music_url;
	}
	public String getMusic_img() {
		return music_img;
	}
	public void setMusic_img(String music_img) {
		this.music_img = music_img;
	}
	public int getPlay_count() {
		return play_count;
	}
	public void setPlay_count(int play_count) {
		this.play_count = play_count;
	}
	@Override
	public String toString() {
		return "Music [music_id=" + music_id + ", music_name=" + music_name + ", music_url=" + music_url
				+ ", music_img=" + music_img + ", play_count=" + play_count + "]";
	}
	
}
