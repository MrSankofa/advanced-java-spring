/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.oneandmany;

import com.codingnomads.springdata.example.mybatis.oneandmany.mappers.ArtistMapper;
import com.codingnomads.springdata.example.mybatis.oneandmany.mappers.SongMapper;
import com.codingnomads.springdata.example.mybatis.oneandmany.models.Artist;
import com.codingnomads.springdata.example.mybatis.oneandmany.models.Song;
import java.util.Collections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneAndManyApplication {

    /* Before running this app, be sure to:

       * create a new empty schema in the mysql database named "mybatis"

       * execute the SQL found "mybatis_tables.sql" on the mybatis schema

       * update the "spring.datasource.url" property in your application.properties file to
         jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

    */

    public static void main(String[] args) {
        SpringApplication.run(OneAndManyApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper, ArtistMapper artistMapper) {
        return (args) -> {
            Artist artist1 = new Artist();
            artist1.setName("Bon Iver");
            artist1.setBio(
                    "Bon Iver is an American indie folk band founded " + "in 2006 by singer-songwriter Justin Vernon.");
            artistMapper.insertNewArtist(artist1);

            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtist(artist1);
            song1.setSongLength(232);
            artist1.setSongs(Collections.singletonList(song1));

            Artist artist2 = new Artist();
            artist2.setName("Gus Dapperton");
            artist2.setBio("Brendan Patrick Rice, better known by his stage name Gus Dapperton, "
                    + "is an American singer and songwriter from Warwick, New York.");
            artistMapper.insertNewArtist(artist2);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtist(artist2);
            song2.setSongLength(279);
            artist2.setSongs(Collections.singletonList(song2));

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song song3 = songMapper.getSongById(1L);
            System.out.println(song3.toString());

            Artist artist3 = artistMapper.getArtistByIdWithSongs(1L);
            System.out.println(artist3.toString());
            System.out.println(artist3.getSongs());
        };
    }
}
