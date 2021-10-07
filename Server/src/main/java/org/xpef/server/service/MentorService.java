package org.xpef.server.service;

import org.xpef.server.model.bo.Mentor;

import java.util.List;

public interface MentorService {

    public List<Mentor> getMentorByNames(List<String> names);

    public List<Mentor> getAllMentors();
}
