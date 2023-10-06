import GeneralApiService from '../apiservices/generalApiService.js'

class LaunchPanelManager {
    constructor(status) {
        this.launchButton = document.getElementById('launchButton');
        this.launchPanel = document.getElementById('statusLaunchPanel');
        this.status = status;
        this._init();
    }
    
    _init() {
        this.launchButton.disabled = true;
        this._addLaunchButtonClickEvent();
        this.apiService = new GeneralApiService();
    }

	_addLaunchButtonClickEvent() {
	    this.launchButton.addEventListener('click', () => {
	      this.launch();
	    });
	}    

    set status(status) {
        this._status = status;
        this.launchPanel.classList.remove('current', 'passed', 'coming-up');
        this.launchPanel.classList.add(status);
        
        if (status === 'current') {
			this.launchButton.disabled = false;
        }
        else if (status !== 'current') {
			this.launchButton.disabled = true;
        }
        
        const event = new Event('statusChange');
            this.launchPanel.dispatchEvent(event);
    }
        
    get status() {
		return this._status;
	}
	
    launch() {
		const endpoint = "/docker/launch";
		const data = {
			imageName: 'pandora-calculation',
			containerName: 'whatever'
		};
    	this.apiService.post(endpoint, data).then(response => {
			if (response===true) {
				this.status = 'passed';
			}
	    })
	    .catch(error => {
	      console.error("Error:", error);
	    });
  	}
}

export default LaunchPanelManager;

