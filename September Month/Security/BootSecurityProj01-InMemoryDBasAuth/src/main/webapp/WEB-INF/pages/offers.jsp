<head>
    <title>Bank - [Dynamic Title]</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body {
            font-family: 'Roboto', Arial, sans-serif;
            background: linear-gradient(135deg, #e0eafc 0%, #cfdef3 100%);
            min-height: 100vh;
            color: #222;
        }
        .navbar {
            background: #ffffffdd;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.07);
            padding: 18px 0;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 40px;
        }
        .navbar a {
            margin: 0 30px;
            color: #b31336;
            font-weight: bold;
            text-decoration: none;
            font-size: 19px;
            transition: color 0.25s;
        }
        .navbar a:hover {
            color: #1769aa;
            text-decoration: underline;
        }
        .container {
            max-width: 400px;
            margin: 48px auto 0 auto;
            background: #fff;
            border-radius: 22px;
            box-shadow: 0 6px 28px rgba(30, 64, 175, 0.09);
            padding: 36px 38px 34px 38px;
        }
        h1 {
            color: #b31336;
            font-size: 2.1em;
            margin-bottom: 24px;
        }
        .menu-link {
            display: flex;
            align-items: center;
            margin-top: 24px;
            font-size: 20px;
            padding: 16px;
            background: #f3f7fb;
            border: 1.5px solid #ececec;
            border-radius: 12px;
            cursor: pointer;
            text-decoration: none;
            color: #1769aa;
            transition: background 0.17s, box-shadow 0.17s;
            box-shadow: 0 1px 8px rgba(30,64,175,0.03);
        }
        .menu-link:hover {
            background: #eaf2fd;
            box-shadow: 0 2px 16px rgba(30,64,175,0.08);
        }
        .icon {
            font-size: 1.5em;
            margin-right: 14px;
        }
        ul.offers-list {
            list-style: none;
            margin-top: 20px;
            margin-bottom: 15px;
        }
        ul.offers-list li {
            margin-bottom: 13px;
            font-size: 18px;
            padding-left: 24px;
            position: relative;
        }
        ul.offers-list li:before {
            content: "✔";
            color: #4baf50;
            margin-right: 8px;
            font-size: 1.1em;
            position: absolute;
            left: 0;
        }
        .info-card {
            font-size: 1.25em;
            color: #222;
            background: #f5f7fa;
            border-radius: 12px;
            box-shadow: 0 1px 8px rgba(120, 120, 120, 0.04);
            padding: 23px;
            margin-bottom: 23px;
            margin-top: 12px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .amt {
            font-weight: bold;
            color: #1769aa;
            font-size: 1.45em;
            margin-left: 3px;
        }
        @media (max-width:500px) {
            .container { padding: 28px 9vw; }
            h1 { font-size: 1.19em; }
            .navbar { flex-direction: column;}
        }
    </style>
</head>

