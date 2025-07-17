<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Healthsure | Home</title>
<style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: 'Segoe UI', sans-serif;
      background: linear-gradient(to bottom, #e0f7fa, #fefefe); /* soft light blue gradient */
      color: #333;
    }

    nav {
      background-color: #e0f7fa;
      box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
      position: fixed;
      top: 0;
      width: 100%;
      z-index: 1000;
    }

    .nav-container {
      max-width: 1200px;
      margin: auto;
      padding: 1rem;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .logo {
      font-size: 1.6rem;
      font-weight: bold;
      color: #4b79a1;
    }

    .nav-links {
      list-style: none;
      display: flex;
      gap: 1.5rem;
    }

    .nav-links a {
      text-decoration: none;
      font-weight: 600;
      color: #4b79a1;
      transition: color 0.3s;
    }

    .nav-links a:hover {
      color: #ff6600;
    }

    .hero {
      height: 90vh;
      background: linear-gradient(rgba(0,0,0,0.4), rgba(0,0,0,0.4)), url('hero-bg.jpg') center/cover no-repeat;
      display: flex;
      align-items: center;
      justify-content: center;
      text-align: center;
      color: #fff;
      padding-top: 60px;
    }

    .hero-content {
      max-width: 600px;
    }

    .hero-content h1 {
      font-size: 2.75rem;
      margin-bottom: 1rem;
      text-shadow: 1px 1px 3px rgba(0,0,0,0.5);
    }

    .hero-content p {
      font-size: 1.15rem;
      margin-bottom: 2rem;
    }

    .cta-btn {
      background-color: #1d4ed8;
      color: #fff;
      padding: 0.75rem 2rem;
      font-size: 1.1rem;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      text-decoration: none;
      box-shadow: 0 4px 10px rgba(29, 78, 216, 0.2);
      transition: background-color 0.3s, transform 0.2s ease;
    }

    .cta-btn:hover {
      background-color: #1e40af;
      transform: translateY(-2px);
    }

    .features {
      max-width: 1200px;
      margin: auto;
      padding: 3rem 1rem;
      display: flex;
      flex-wrap: wrap;
      gap: 2rem;
      justify-content: center;
    }

    .feature {
      flex: 1;
      min-width: 250px;
      text-align: center;
      background-color: #ffffff;
      padding: 1.5rem;
      border-radius: 12px;
      box-shadow: 0 6px 16px rgba(0, 0, 0, 0.07);
      transition: transform 0.3s ease;
    }

    .feature:hover {
      transform: scale(1.05);
    }

    .feature i {
      font-size: 2.5rem;
      color: #1d4ed8;
      margin-bottom: 0.75rem;
      transition: transform 0.3s;
    }

    .feature:hover i {
      transform: scale(1.2);
    }

    .feature h3 {
      font-size: 1.25rem;
      margin-bottom: 0.5rem;
    }

    .feature p {
      font-size: 0.95rem;
      color: #555;
    }

    .footer {
      background: linear-gradient(to right, #0f172a, #1e293b);
      color: #f1f5f9;
      padding: 60px 20px 20px;
      font-family: 'Segoe UI', sans-serif;
    }

    .footer-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      gap: 2rem;
      max-width: 1200px;
      margin: auto;
    }

    .footer-brand {
      max-width: 240px;
    }

    .footer-logo {
      font-size: 2rem;
      font-weight: 700;
      color: #38bdf8;
    }

    .footer-logo-img {
      width: 60px;
      height: auto;
      margin-bottom: 0.5rem;
      border-radius: 50%;
    }

    .footer-links,
    .footer-contact,
    .footer-social {
      flex: 1;
      min-width: 180px;
    }

    .footer-links ul {
      list-style: none;
      padding: 0;
      margin-top: 0.5rem;
    }

    .footer-links ul li {
      margin-bottom: 0.5rem;
    }

    .footer-links ul li a {
      color: #f1f5f9;
      text-decoration: none;
      transition: color 0.3s;
    }

    .footer-links ul li a:hover {
      color: #38bdf8;
    }

    .footer-contact p {
      margin: 0.5rem 0;
      font-size: 0.95rem;
    }

    .footer-social .icons a {
      margin-right: 0.75rem;
      display: inline-block;
      transition: transform 0.3s;
    }

    .footer-social .icons img {
      width: 24px;
      height: 24px;
      filter: invert(100%);
    }

    .footer-social .icons a:hover {
      transform: scale(1.2);
    }

    .footer-bottom {
      text-align: center;
      padding-top: 30px;
      font-size: 0.9rem;
      border-top: 1px solid #334155;
      margin-top: 40px;
    }

    @media (max-width: 768px) {
      .nav-container {
        flex-direction: column;
        align-items: flex-start;
      }

      .nav-links {
        flex-direction: column;
        gap: 0.75rem;
        margin-top: 1rem;
      }

      .hero-content h1 {
        font-size: 2.2rem;
      }
    }
</style>
</head>
<body>

  <nav>
    <div class="nav-container">
      <div class="logo">Healthsure</div>
      <ul class="nav-links">
        <li><a href="#">Home</a></li>
        <li><a href="#plans">Plans</a></li>
        <li><a href="#contact">Contact</a></li>
      </ul>
    </div>
  </nav>

  <section class="hero">
    <div class="hero-content">
      <h1>Secure Tomorrow, Today</h1>
      <p>Your trusted partner in health and life protection—tailored plans, instant coverage, and peace of mind.</p>
      <a href="NApplicationForm.jsf" class="cta-btn">Health Insurance</a>
    </div>
  </section>

  <section class="features">
    <div class="feature">
      <i class="fas fa-stopwatch"></i>
      <h3>Quick Quotes</h3>
      <p>Get a tailored insurance quote in under three minutes—no waiting, no hassle.</p>
    </div>
    <div class="feature">
      <i class="fas fa-users"></i>
      <h3>Family Coverage</h3>
      <p>Protect your loved ones with comprehensive plans for all age groups.</p>
    </div>
    <div class="feature">
      <i class="fas fa-headset"></i>
      <h3>24/7 Support</h3>
      <p>Our team is always available to guide you—anytime, anywhere.</p>
    </div>
  </section>

  <!-- ========== Footer Start ========== -->
  <footer class="footer">
    <div class="footer-container">
      <div class="footer-brand">
        <img src="logo.png" alt="Healthsure Logo" class="footer-logo-img">
        <div class="footer-logo">Healthsure</div>
        <p>Your health, our priority. Trusted plans for every stage of life.</p>
      </div>

      <div class="footer-links">
        <h4>Quick Links</h4>
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#plans">Plans</a></li>
                  <li><a href="#contact">Contact</a></li>
          <li><a href="#">FAQs</a></li>
        </ul>
      </div>

      <div class="footer-contact" id="contact">
        <h4>Contact</h4>
        <p>Email: support@healthsure.com</p>
        <p>Phone: +91 98765 43210</p>
        <p>Address: 123, Wellness Street, New Delhi, India</p>
      </div>

      <div class="footer-social">
        <h4>Follow Us</h4>
        <div class="icons">
          <a href="#"><img src="facebook.png" alt="Facebook"></a>
          <a href="#"><img src="twitter.png" alt="Twitter"></a>
          <a href="#"><img src="instagram.png" alt="Instagram"></a>
        </div>
      </div>
    </div>

    <div class="footer-bottom">
      <p>&copy; 2025 Healthsure. All rights reserved.</p>
    </div>
  </footer>

</body>
</html>
          