

import java.util.*;

public class CastVote {

    private static Set<Integer> voters = new HashSet<>();
    private static Map<Integer, Integer> votes = new HashMap<>();

    public static boolean castVote(int voterId, int candidateId) {
        if (voters.contains(voterId) ||
            !AddCandidate.getCandidates().containsKey(candidateId)) {
            return false;
        }
        voters.add(voterId);
        votes.put(candidateId, votes.getOrDefault(candidateId, 0) + 1);
        return true;
    }

    public static Map<Integer, Integer> getVotes() {
        return votes;
    }
}
