import Header from "./Header";

function Contact() {
   

    return (
        <><Header/>
        <div className="container py-6">
            <center>
                <h2 className="my-6">Get In Touch</h2>
                <br/>
                <br/>
                <br/>

                <div className="contact-info">
                    <div>
                        <h5>Our Location</h5>
                        <p>123 Culinary Street, Flavorville, USA</p>
                    </div>

                    <div>
                        <h5>Contact Number</h5>
                        <p>+01 234 567 88</p>
                    </div>
                </div>
            </center>
        </div>
        </>
    );
}

export default Contact;
