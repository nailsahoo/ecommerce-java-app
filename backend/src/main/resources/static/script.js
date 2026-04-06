fetch('/products')
    .then(response => response.json())
    .then(data => {
        let container = document.getElementById('product-list');

        data.forEach(product => {
            let div = document.createElement('div');
            div.className = 'product';

            div.innerHTML = `
                <h3>${product.name}</h3>
                <p>Category: ${product.category}</p>
                <p>Price: ₹${product.price}</p>
            `;

            container.appendChild(div);
        });
    });
