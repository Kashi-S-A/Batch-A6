<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Commerce Home</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
        }

        /* Header */
        .header {
            background-color: #222;
            color: white;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h1 {
            margin: 0;
            font-size: 24px;
        }

        .header a {
            color: white;
            text-decoration: none;
            margin-left: 15px;
            font-size: 14px;
        }

        /* Banner */
        .banner {
            background-color: #007bff;
            color: white;
            padding: 40px;
            text-align: center;
        }

        .banner h2 {
            margin-bottom: 10px;
        }

        /* Product Section */
        .products {
            padding: 30px;
        }

        .products h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }

        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 20px;
        }

        .product-card {
            background: white;
            padding: 15px;
            border-radius: 6px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            text-align: center;
        }

        .product-card img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            margin-bottom: 10px;
        }

        .product-card h3 {
            font-size: 16px;
            margin: 10px 0;
        }

        .product-card p {
            color: #555;
            font-size: 14px;
        }

        .product-card button {
            margin-top: 10px;
            padding: 8px 12px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            border-radius: 4px;
        }

        .product-card button:hover {
            background-color: #0056b3;
        }

        /* Footer */
        .footer {
            background-color: #222;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 30px;
            font-size: 14px;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <div class="header">
        <h1>ShopEasy</h1>
        <div>
            <a href="#">Home</a>
            <a href="#">Products</a>
            <a href="#">Cart</a>
            <a href="#">Logout</a>
        </div>
    </div>

    <!-- Banner -->
    <div class="banner">
        <h2>Welcome to ShopEasy</h2>
        <p>Your one-stop shop for everything!</p>
    </div>

    <!-- Products -->
    <div class="products">
        <h2>Featured Products</h2>

        <div class="product-grid">
            <div class="product-card">
                <img src="https://via.placeholder.com/200" alt="Product">
                <h3>Product One</h3>
                <p>₹999</p>
                <button>Add to Cart</button>
            </div>

            <div class="product-card">
                <img src="https://via.placeholder.com/200" alt="Product">
                <h3>Product Two</h3>
                <p>₹1499</p>
                <button>Add to Cart</button>
            </div>

            <div class="product-card">
                <img src="https://via.placeholder.com/200" alt="Product">
                <h3>Product Three</h3>
                <p>₹1999</p>
                <button>Add to Cart</button>
            </div>

            <div class="product-card">
                <img src="https://via.placeholder.com/200" alt="Product">
                <h3>Product Four</h3>
                <p>₹799</p>
                <button>Add to Cart</button>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        © 2026 ShopEasy | All Rights Reserved
    </div>

</body>
</html>
