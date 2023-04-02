package com.music.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.music.dao.MusicDaoImp;
import com.music.entity.Music;
import com.music.util.DBHelper;

public class MusicServiceImp implements MusicService{
	private MusicDaoImp md;
	public MusicServiceImp() {
		md = new MusicDaoImp();
	}
	@Override
	public List<Music> findAllMusics() {
		ArrayList<Music> list = new ArrayList<Music>();
		Connection conn = DBHelper.getConnection();
		try {
			ResultSet set = md.selectAllMusics(conn);
			while(set.next()) {
				int music_id = set.getInt("music_id");
				String music_name = set.getString("music_name");
				String music_url = set.getString("music_url");
				String music_img = set.getString("music_img");
				int play_count = set.getInt("play_count");
				
				list.add(new Music(music_id,music_name,music_url,music_img,play_count));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			md.closeAll();
		}
		return list;
	}
}
