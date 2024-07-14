document.addEventListener('DOMContentLoaded', function() {
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('success')) {
        Swal.fire({
            title: 'Success!',
            text: 'Student successfully added.',
            icon: 'success',
            confirmButtonText: 'OK'
        });
    }
});