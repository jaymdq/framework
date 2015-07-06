package stream.twitter;

import stream.StatusExt;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * Twitter Listener
 * 
 * @author Maximiliano
 *
 */
public class TwitterListener implements StatusListener {
	
	private StreamTwitterWorker parent = null;

	public TwitterListener (StreamTwitterWorker parent){
		this.parent = parent;
	}
	
	@Override
	public void onException(Exception arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatus(Status status) {
		this.parent.notify(new StatusExt(status));
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub

	}

}
