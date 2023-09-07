class SelectFilePanelManager {
    constructor(status) {
        this.fileInput = document.getElementById('fileInput');
        this.fileContents = document.getElementById('fileContents');
        this.selectFilePanel = document.getElementById("statusSelectFilePanel");
        this.status = status;
        this._init();
    }

    _init() {
        this.fileContents.textContent = 'No file selected.';
        this._initFileInputChangeListener(); // Call the method to set up the event listener
    }

    _initFileInputChangeListener() {
        this.fileInput.addEventListener('change', () => {
            const file = this.fileInput.files[0];

            if (file) {
                const fileName = file.name; // Get the filename
                this.fileContents.textContent = 'Selected File: ' + fileName;
                this.status = 'passed';
            }
        });
    }
    
    set status(status) {
        this._status = status;
        this.selectFilePanel.classList.remove('current', 'passed', 'coming-up');
        this.selectFilePanel.classList.add(status);
        
        const event = new Event('statusChange');
            this.dispatchEvent(event);
    }
        
    get status() {
		return this._status;
	}
	
	// Custom event emitter methods
    addEventListener(eventType, callback) {
        if (!this._eventListeners) {
            this._eventListeners = {};
        }
        if (!this._eventListeners[eventType]) {
            this._eventListeners[eventType] = [];
        }
        this._eventListeners[eventType].push(callback);
    }

    dispatchEvent(event) {
        if (!this._eventListeners || !this._eventListeners[event.type]) {
            return;
        }
        this._eventListeners[event.type].forEach(callback => {
            callback(event);
        });
    }
}

export default SelectFilePanelManager;