import config from './apiConfig.js';

class GeneralApiService {
	constructor() {
		this.baseUrl = config.baseUrl;
	}

	get(endpoint) {
    	try {
      		const response = fetch(`${this.baseUrl}${endpoint}`);
      		if (!response.ok) {
        		throw new Error(`HTTP error! Status: ${response.status}`);
      		}
      		return response.json();
    	} catch (error) {
      		console.error('Error:', error);
			throw error;
    	}
  	}

  	async post(endpoint, data) {
    	try {
      		const response = await fetch(`${this.baseUrl}${endpoint}`, {
	        	method: 'POST',
				headers: {
				    'Content-Type': 'application/json', // Add this line
				},
	        	body: JSON.stringify(data),
      		});
      	return await response.json();
    	} catch (error) {
      		console.error('Error:', error);
     		throw error;
    	}
  	}
}

export default GeneralApiService;