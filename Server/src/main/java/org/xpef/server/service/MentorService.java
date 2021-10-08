package org.xpef.server.service;

import org.xpef.server.model.bo.Mentor;

import java.util.List;

public interface MentorService {

    public List<Mentor> getMentorByNames(List<String> names);

    public List<Mentor> getAllMentors();

    public List<Mentor> getTypeMentors(int type);

    public Boolean updateMentor(Mentor mentor);

    public List<Mentor> getMentorByIds(List<Integer> mentorIds);

}
