package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.InvalidFieldException;
import business.controllers.VideoController;
import business.wrapper.VideoWrapper;
import data.services.DataService;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.VIDEOS)
public class VideoResource {
	
	public VideoController videoController;
	
	public DataService dataService;
	
	@Autowired
	public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
	
	@Autowired
	public void setVideoController(VideoController videoController) {
        this.videoController = videoController;
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void uploadVideo(@AuthenticationPrincipal User activeUser, @RequestBody VideoWrapper videoWrapper) throws InvalidFieldException {
		dataService.validateField(videoWrapper.getTitle(), "title");
		dataService.validateField(videoWrapper.getPlace(), "place");
		dataService.validateField(videoWrapper.getYoutubeUrl(), "youtube url");
		videoController.uploadVideo(activeUser.getUsername(), videoWrapper);
	}

}
