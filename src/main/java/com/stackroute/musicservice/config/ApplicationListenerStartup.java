package com.stackroute.musicservice.config;
import com.stackroute.musicservice.domain.Track;
import com.stackroute.musicservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;

import static com.stackroute.musicservice.config.CommandLineRunnerStartup.logs;


@Component
public class ApplicationListenerStartup implements ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;

    @Autowired
    public ApplicationListenerStartup(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        logs.info("Inserting data on start");

        Track trackOne = new Track(5,"When the night is over","Singer : Lord Huron");
        trackRepository.save(trackOne);
        Track trackTwo = new Track(6,"High on life","Singer : Bonn");
        trackRepository.save(trackTwo);

        logs.info("data successfully inserted");
    }
}
