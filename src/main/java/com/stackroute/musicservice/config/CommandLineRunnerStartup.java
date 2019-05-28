package com.stackroute.musicservice.config;
import com.stackroute.musicservice.domain.Track;
import com.stackroute.musicservice.repository.TrackRepository;
import com.stackroute.musicservice.domain.Track;
import com.stackroute.musicservice.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerStartup implements CommandLineRunner {

    public static final Logger logs = LoggerFactory.getLogger(CommandLineRunnerStartup.class);
    private TrackRepository trackRepository;

    @Autowired
    public CommandLineRunnerStartup(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        logs.info("Inserting data on start");

        Track trackOne = new Track(5,"fdsds","frgv");
        trackRepository.save(trackOne);
        Track trackTwo = new Track(13,"abc","Singer : fvhjg");
        trackRepository.save(trackTwo);

        logs.info("data successfully inserted");
    }
}