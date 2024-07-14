<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Myntra HackerRamp: Guess the Prize</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0 20px;
        }
        h1, h2, h3, h4, h5 {
            color: #333;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        ul li {
            margin-bottom: 10px;
        }
        a {
            color: #1E90FF;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Myntra HackerRamp: Guess the Prize</h1>
    <p>Welcome to the Myntra HackerRamp: Guess the Prize project! This initiative aims to enhance the shopping experience on Myntra by engaging users in a fun and interactive game and providing personalized recommendations.</p>
    
    <h2>Table of Contents</h2>
    <ul>
        <li><a href="#introduction">Introduction</a></li>
        <li><a href="#team-members">Team Members</a></li>
        <li><a href="#problem-statement">Problem Statement</a></li>
        <li><a href="#solution">Solution</a>
            <ul>
                <li><a href="#personalized-color-analysis">Personalized Color Analysis</a></li>
                <li><a href="#guess-the-prize">Guess the Prize</a></li>
                <li><a href="#aesthetic-trend-recommendation">Aesthetic / Trend Recommendation</a></li>
            </ul>
        </li>
        <li><a href="#benefits">Benefits</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#usage">Usage</a></li>
        <li><a href="#contributing">Contributing</a></li>
        <li><a href="#license">License</a></li>
    </ul>

    <h2 id="introduction">Introduction</h2>
    <p>The Myntra HackerRamp: Guess the Prize project is designed to engage users by providing personalized recommendations and interactive games that enhance their shopping experience.</p>

    <h2 id="team-members">Team Members</h2>
    <ul>
        <li>Amisha Singh - DSCE Bengaluru</li>
        <li>Akriti Khetan - DSCE Bengaluru</li>
        <li>Swarneem Ishu - DSCE Bengaluru</li>
    </ul>

    <h2 id="problem-statement">Problem Statement</h2>
    <p>Customers on Myntra face the following issues:</p>
    <ul>
        <li>Difficulty in analyzing the right set of colors that complement their skin tone for both clothes and makeup.</li>
        <li>Lack of engagement by customers, especially Gen Z, who view Myntra as a need-based convenience rather than a daily usage application.</li>
        <li>Difficulty in discovering current trends and aesthetic styles, with many styles and pieces remaining undiscovered due to mainstream marketing.</li>
    </ul>

    <h2 id="solution">Solution</h2>
    
    <h3 id="personalized-color-analysis">Personalized Color Analysis</h3>
    <p>We integrate a feature that allows users to upload a photo or input details about their skin tone, hair color, and style preferences. Using AI-powered image analysis and color theory algorithms, we generate personalized color palettes and display these recommendations in the user's shopping interface for a customized experience.</p>
    
    <h3 id="guess-the-prize">Guess the Prize</h3>
    <p>This game allows users to guess the price of showcased products, rewarding correct guesses with Myntra Super Coins. By integrating this feature into the shopping website, users can accumulate points with each game. Myntra Insiders receive additional perks like exclusive deals and priority customer support, enhancing their shopping experience.</p>
    
    <h3 id="aesthetic-trend-recommendation">Aesthetic / Trend Recommendation</h3>
    <p>Using AI-powered tools, we identify recent trends and provide corresponding product recommendations ordered by trend, alongside regular categorization by brands or clothing items. This helps users discover emerging trends, hidden gems, and products tailored to their taste.</p>

    <h2 id="benefits">Benefits</h2>
    <ul>
        <li>Trend-Centric Recommendations: Provides clothing suggestions that align with recent trends.</li>
        <li>Platform Engagement: The "Guess the Prize" feature encourages daily usage by providing entertainment that keeps users engaged.</li>
        <li>Personalized Recommendations: Offers tailored recommendations that complement individual skin tones, hair colors, and personal styles.</li>
        <li>Underrated Product Marketing: Assists in marketing products overshadowed by regular branding efforts.</li>
        <li>Promoting Customer Loyalty: Engagement features foster daily usage habits, encouraging customers to remain active on the app.</li>
        <li>Trend Identification: Identifies recent trends and provides corresponding product recommendations.</li>
    </ul>

    <h2 id="installation">Installation</h2>
    <p>To get started with the project, follow these steps:</p>
    <ol>
        <li><strong>Clone the Repository:</strong>
            <pre><code>git clone https://github.com/amisha229/MyntraHackerRamp.git</code></pre>
        </li>
        <li><strong>Navigate to the Project Directory:</strong>
            <pre><code>cd MyntraHackerRamp</code></pre>
        </li>
        <li><strong>Install Dependencies:</strong>
            <pre><code>npm install</code></pre>
        </li>
        <li><strong>Start the Development Server:</strong>
            <pre><code>npm start</code></pre>
        </li>
    </ol>

    <h2 id="usage">Usage</h2>
    <p>1. <strong>Launch the Application:</strong>
        Once the development server is running, open your browser and navigate to <code>http://localhost:3000</code>.</p>
    <p>2. <strong>Play the Game:</strong>
        Follow the on-screen instructions to start guessing the prices of various products. Enter your guesses and receive immediate feedback.</p>
    <p>3. <strong>Check the Leaderboard:</strong>
        See how your score compares to others on the leaderboard.</p>

    <h2 id="contributing">Contributing</h2>
    <p>We welcome contributions to enhance the project! To contribute:</p>
    <ol>
        <li><strong>Fork the Repository:</strong>
            Click the "Fork" button on the top right of the repository page on GitHub.</li>
        <li><strong>Clone Your Fork:</strong>
            <pre><code>git clone https://github.com/&lt;your-username&gt;/MyntraHackerRamp.git</code></pre>
        </li>
        <li><strong>Create a New Branch:</strong>
            <pre><code>git checkout -b feature/your-feature-name</code></pre>
        </li>
        <li><strong>Make Your Changes:</strong>
            Implement your feature or fix a bug.</li>
        <li><strong>Commit Your Changes:</strong>
            <pre><code>git commit -m "Add feature: your feature name"</code></pre>
        </li>
        <li><strong>Push to Your Branch:</strong>
            <pre><code>git push origin feature/your-feature-name</code></pre>
        </li>
        <li><strong>Open a Pull Request:</strong>
            Navigate to the original repository and click the "New Pull Request" button.</li>
    </ol>

    <h2 id="license">License</h2>
    <p>This project is licensed under the MIT License. See the <code>LICENSE</code> file for details.</p>
</body>
</html>
