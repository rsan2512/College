document.getElementById('regForm').addEventListener('submit', function (e) {
  e.preventDefault();
  const name     = document.getElementById('name').value.trim();
  const gender   = document.querySelector('input[name="gender"]:checked');
  const mobile   = document.getElementById('mobile').value.trim();
  const address  = document.getElementById('address').value.trim();
  const country  = document.getElementById('country').value;
  const email    = document.getElementById('email').value.trim();
  const password = document.getElementById('password').value;

  if (name === '') {
    alert('Name is required.'); return;
  }
  if (!gender) {
    alert('Please select a gender.'); return;
  }
  if (mobile === '') {
    alert('Mobile number is required.'); return;
  }
  if (!/^\d{10}$/.test(mobile)) {
    alert('Mobile must be exactly 10 digits.'); return;
  }
  if (address === '') {
    alert('Address is required.'); return;
  }
  if (country === '') {
    alert('Please select a country.'); return;
  }
  if (email === '') {
    alert('Email is required.'); return;
  }
  if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
    alert('Enter a valid email address.'); return;
  }
  if (password === '') {
    alert('Password is required.'); return;
  }
  if (password.length < 6 || password.length > 15) {
    alert('Password must be between 6 and 15 characters.'); return;
  }

  alert('Registration successful!');
  document.getElementById('regForm').reset();
});