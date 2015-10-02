package benworks.bookcode.jtis.chapter3;

public class VoteMsg {

	private boolean inquiry;

	private boolean response;

	private int candidateID;

	private long voteCount;

	public VoteMsg(boolean response, boolean inquiry, int candidateID, long voteCount) {
		super();
		this.response = response;
		this.inquiry = inquiry;
		this.candidateID = candidateID;
		this.voteCount = voteCount;
	}

	public boolean isInquiry() {
		return inquiry;
	}

	public int getCandidateID() {
		return candidateID;
	}

	public boolean isResponse() {
		return response;
	}

	public long getVoteCount() {
		return voteCount;
	}

	public void setInquiry(boolean inquiry) {
		this.inquiry = inquiry;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public void setCandidateID(int candidateID) {
		this.candidateID = candidateID;
	}

	public void setVoteCount(long voteCount) {
		this.voteCount = voteCount;
	}

}
