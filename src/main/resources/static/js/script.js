function signup() {
    console.log('Signup button clicked');
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;

    // Perform AJAX request to the backend for user signup
    // You can use Fetch API or any AJAX library like Axios
    // Example using Fetch API:
    fetch('/api/users/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, email }),
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return response.text().then(text => {
                    console.error('Error response content:', text);
                    throw new Error('Error during signup');
                });
            }
        })
        .then(data => {
            alert(data);
        })
        .catch(error => {
            console.error('Error:', error.message);

            // Check for network errors
            if (!response.ok && error instanceof TypeError) {
                console.error('Network error occurred');
            }

            // Log the entire response for debugging
            console.error('Full response:', response);
        });

}







function uploadDocument() {
    const documentFile = document.getElementById('document').files[0];
    const userId = 1; // Replace with the actual user ID

    // Perform AJAX request to the backend for document upload
    // You need to handle file uploads appropriately on the server side
    const formData = new FormData();
    formData.append('file', documentFile);

    fetch(`/api/documents/upload/${userId}`, {
        method: 'POST',
        body: formData,
    })
        .then(response => response.json())
        .then(data => {
            alert(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
