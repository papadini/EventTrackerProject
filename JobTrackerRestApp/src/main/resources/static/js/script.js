window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();
});

function init() {

	document.jobForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var jobId = document.jobForm.jobId.value;
		console.log(jobId);
		if (!isNaN(jobId) && jobId > 0) {
			getJobById(jobId);
		}
	});

	document.newJobForm.submit.addEventListener('click', function(event) {
		event.preventDefault();
		let form = event.target.parentElement;
		console.log(event.target);

		let job = {
			position : form.position.value,
			applied : form.applied.value,
			interviewNotes : form.interviewNotes.value,
			salary : form.salary.value,
			offerd : form.applied.value,
			created : form.date.value

		}
		console.log(job);
		submitNewJob(job);
	});

	document.newCompForm.submit.addEventListener('click', function(event) {
		event.preventDefault();
		console.log('test');
		let form = event.target.parentElement;

		let comp = {
			name : form.name.value,
			description : form.description.value,
			benefits : form.benefits.value,
			address : form.address.value,
			phoneNumber : form.phoneNumber.value
		}
		console.log(comp);
		submitNewComp(comp);
	});

	document.jobForm.seeAll.addEventListener('click', function(event) {
		event.preventDefault();
		getAllJobs();

	});

	document.jobForm.seeAllComp.addEventListener('click', function(event) {
		event.preventDefault();
		getAllCompanies();
	});

}// init function end

function submitNewJob(job) {
	let xhr = new XMLHttpRequest();
	let jobJson = JSON.stringify(job);
	xhr.open('POST', 'api/jobs');
	xhr.setRequestHeader('Content-type', 'application/json');// specify JSON
	// req body
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				// grabs response body of new film. right now only and id
				let newJob = JSON.parse(xhr.responseText);

				getJobById(newJob);
			}
		}// first if close brace
	}; // onreadystatechange close brace

	xhr.send(jobJson);
}// submitNewJob end

function submitNewComp(company) {
	let xhr = new XMLHttpRequest();
	let compJson = JSON.stringify(company);
	console.log(compJson);
	xhr.open('POST', 'api/companies');
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 201) {
				// grabs response body of new film. right now only and id
				let newcomp = JSON.parse(xhr.responseText);
				console.log( newcomp);
			}
		}// end first if
	}
	xhr.send(compJson);

}// end submit new comp

function getJobById(jobId) {
	console.log(jobId);
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/jobs/' + jobId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let job = JSON.parse(xhr.responseText);
				console.log(job);
				console.log(job.company.id);
				displayJob(job);
				getCompanyById(job.company.id);
			}
		}// first if close brace
	}; // onreadystatechange close brace
	xhr.send();
} // getJobById end

function getCompanyById(compId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/companies/' + compId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let company = JSON.parse(xhr.responseText);
				console.log(company);
				displayCompany(company);
			}
		}// end first if

	}// end onreadystatechange
	xhr.send();
}// end companybyid

function getAllJobs() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/jobs');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let jobs = JSON.parse(xhr.responseText);
				console.log(jobs);
				displayAllJobs(jobs);
			}
		}// end first if
	}
	xhr.send();
}// end get all jobs

function getAllCompanies() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/companies');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let comps = JSON.parse(xhr.responseText);
				console.log(comps);
				displayAllCompanies(comps);
			}
		}// end first if
	}
	xhr.send();
}// end get all companies

function displayJob(job) {
	var jobData = document.getElementById('jobData');
	jobData.textContent = '';

	let h2 = document.createElement('h2');
	h2.textContent = job.position + " ID: " + job.id;
	jobData.appendChild(h2);

	let ul1 = document.createElement('ul');
	let applied = document.createElement('li');
	applied.textContent = 'Applied: ' + job.applied;
	ul1.appendChild(applied);
	let salary = document.createElement('li');
	salary.textContent = 'Salary: ' + job.salary;
	ul1.appendChild(salary);
	let offered = document.createElement('li');
	offered.textContent = 'Offered: ' + job.offerd;
	ul1.appendChild(offered);
	let date = document.createElement('li');
	date.textContent = 'Date: ' + job.created;
	ul1.appendChild(date);
	let br = document.createElement('br');
	ul1.appendChild(br);

	let interviewN = document.createElement('blockquote');
	interviewN.textContent = 'Interview Notes: ' + job.interviewNotes;
	ul1.appendChild(interviewN);

	jobData.appendChild(ul1);

}// display job ends

function displayCompany(company) {
	var companyData = document.getElementById('companyData');
	companyData.textContent = '';
	let h3 = document.createElement('h3');
	h3.textContent = 'Company: ' + company.name;
	companyData.appendChild(h3);

	let ul = document.createElement('ul');
	let description = document.createElement('blockquote');
	description.textContent = 'Description: ' + company.description;
	ul.appendChild(description);

	let benefits = document.createElement('li');
	benefits.textContent = 'Benefits: ' + company.benefits;
	ul.appendChild(benefits);
	let address = document.createElement('li');
	address.textContent = 'Address: ' + company.address;
	ul.appendChild(address);
	let phoneNumber = document.createElement('li');
	phoneNumber.textContent = 'Phone Number: ' + company.phoneNumber;
	ul.appendChild(phoneNumber);

	companyData.appendChild(ul);

}// display company end

function displayAllJobs(jobs) {
	console.log(jobs);

	var jobData = document.getElementById('jobData');
	jobData.textContent = '';
	let table = document.createElement('table');

	// table headers
	let row1 = document.createElement('tr');

	let jobTH = document.createElement('th');
	jobTH.textContent = 'Positions';
	row1.appendChild(jobTH);

	let salaryTH = document.createElement('th');
	salaryTH.textContent = 'Salary';
	row1.appendChild(salaryTH);

	let appCol = document.createElement('th');
	appCol.textContent = 'Applied';
	row1.appendChild(appCol);

	let compCol = document.createElement('th');
	compCol.textContent = 'Companies';
	row1.appendChild(compCol);

	let addTH = document.createElement('th');
	addTH.textContent = 'Location'
	row1.appendChild(addTH);

	let phoneCol = document.createElement('th');
	phoneCol.textContent = 'Contact';
	row1.appendChild(phoneCol);

	table.appendChild(row1);

	// table info

	for (let i = 0; i < jobs.length; i++) {

		let row = document.createElement('tr');

		let jobPos = document.createElement('td');
		jobPos.textContent = jobs[i].position;
		row.appendChild(jobPos);

		let salary = document.createElement('td');
		salary.textContent = jobs[i].salary;
		row.appendChild(salary);

		let app = document.createElement('td');
		app.textContent = jobs[i].applied;
		row.appendChild(app);

		let comp = document.createElement('td');
		comp.textContent = jobs[i].company.name;
		row.appendChild(comp);

		let add = document.createElement('td');
		add.textContent = jobs[i].company.address;
		row.appendChild(add);

		let phone = document.createElement('td');
		phone.textContent = jobs[i].company.phoneNumber;
		row.appendChild(phone);

		table.appendChild(row);

	}// end for loop

	jobData.appendChild(table);
	let br = document.createElement('br');
	jobData.appendChild(br);

} // end displayall jobs

function displayAllCompanies(comps) {
	var companyData = document.getElementById('companyData');
	companyData.textContent = '';

	let table = document.createElement('table');

	// table headers
	let row1 = document.createElement('tr');

	let compTH = document.createElement('th');
	compTH.textContent = 'Company';
	row1.appendChild(compTH);

	let compId = document.createElement('th');
	compId.textContent = 'ID';
	row1.appendChild(compId);

	let addTH = document.createElement('th');
	addTH.textContent = 'Location';
	row1.appendChild(addTH);

	let contactTH = document.createElement('th');
	contactTH.textContent = 'Contact';
	row1.appendChild(contactTH);

	table.appendChild(row1);

	for (let i = 0; i < comps.length; i++) {

		let row = document.createElement('tr');

		let comp = document.createElement('td');
		comp.textContent = comps[i].name;
		row.appendChild(comp);

		let cId = document.createElement('td');
		cId.textContent = comps[i].id;
		row.appendChild(cId);

		let address = document.createElement('td');
		address.textContent = comps[i].address;
		row.appendChild(address);

		let contactTD = document.createElement('td');
		contactTD.textContent = comps[i].phoneNumber;
		row.appendChild(contactTD);
		table.appendChild(row);

	}// end for loop

	companyData.appendChild(table);
	let br = document.createElement('br');
	companyData.appendChild(br);

}
