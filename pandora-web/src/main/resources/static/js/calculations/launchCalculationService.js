import SelectFilePanelManager from '../fragments/selectFilePanelManager.js'
import LaunchPanelManager from './launchPanelManager.js'

class LaunchCalculationService {
    constructor() {
		this.selectFilePanelManager = new SelectFilePanelManager('current');
		this.launchPanelManager = new LaunchPanelManager('coming-up');
		this._init();
    }
    
    _init() {
        this._initSelectFilePanelListener();
    }
    
    _initSelectFilePanelListener() {
        this.selectFilePanelManager.addEventListener('statusChange', () => {
            const selectFilePanelStatus = this.selectFilePanelManager.status;

            if (selectFilePanelStatus === 'passed') {
				this.launchPanelManager.status = 'current';
            }
        });
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const service = new LaunchCalculationService();

});

export default LaunchCalculationService;