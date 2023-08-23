import { MDBCarousel, MDBCarouselItem } from "mdb-react-ui-kit";

function About() {
    return (<>
        <center>
            <div className="container">
                <h1 className="my-3">About Us</h1>
                <p>
                    Welcome to Food-E-Sthaan – a culinary haven where flavors, aromas, and cultures unite to create unforgettable dining experiences. At Food-E-Sthaan, we're passionate about crafting exceptional moments for our guests through exquisite cuisine, impeccable service, and a warm, inviting ambiance. <br />

                    <h4>Our Story:</h4>
                    Food-E-Sthaan was born from a deep-rooted love for authentic flavors and a desire to share them with the world. Our journey began with a simple yet profound vision – to create a space where food enthusiasts could embark on a gastronomic adventure, exploring the rich tapestry of tastes that define various regions and cultures.

                    <h4 className="my-3">Our Popular Dishes:</h4>

                    <MDBCarousel showControls dealy={3000} >
                        <MDBCarouselItem
                            className='w-100 d-block'
                            itemId={1}
                            src='./img/f4.jpg'
                            alt='...'
                        />
                        <MDBCarouselItem
                            className='w-100 d-block'
                            itemId={2}
                            src='./img/f2.jpg'
                            alt='...'
                        />
                        <MDBCarouselItem
                            className='w-100 d-block'
                            itemId={3}
                            src='./img/f3.jpg'
                            alt='...'
                        />
                    </MDBCarousel>

                    <h4 className="my-3">Our Culinary Philosophy:</h4>
                    Central to Food-E-Sthaan's philosophy is a commitment to culinary excellence. Our talented team of chefs, each an expert in their respective cuisines, curate a diverse and tantalizing menu that showcases the finest ingredients and traditional cooking techniques. We believe in honoring tradition while embracing innovation, resulting in dishes that are both classic and contemporary, familiar yet exciting.

                    <h4 className="my-3">The Dining Experience:</h4>
                    Step into Food-E-Sthaan and be transported to a world of flavors. Our thoughtfully designed interiors blend modern aesthetics with rustic charm, creating an inviting atmosphere that is perfect for intimate dinners, lively celebrations, or casual get-togethers. Whether you're indulging in a romantic dinner for two or hosting a special event, we promise an unforgettable experience that caters to all your senses.

                    <h4 className="my-3">Farm-to-Table Freshness:</h4>
                    We take great pride in sourcing the freshest, locally-sourced ingredients to ensure every dish is a masterpiece of taste and quality. Our commitment to sustainability extends beyond the kitchen, as we strive to minimize our ecological footprint and support local farmers and producers.

                    <h4 className="my-3">Community and Connection:</h4>
                    Food-E-Sthaan is more than just a restaurant; it's a place where people come together to share stories, connect, and create lasting memories. We invite you to savor every bite, engage in meaningful conversations, and immerse yourself in the rich cultural heritage that our dishes embody.

                    <h4 className="my-3">Exceptional Service:</h4>
                    Your satisfaction is our top priority, and our dedicated staff is here to cater to your every need. From the moment you walk through our doors until the time you bid us farewell, expect nothing short of impeccable service and genuine hospitality.

                    <h4 className="my-3">Join Us:</h4>
                    Embark on a culinary journey like no other. Whether you're an adventurous foodie, a connoisseur of flavors, or simply seeking a delightful dining experience, Food-E-Sthaan welcomes you to join us on this epicurean expedition.

                    Visit us today and let Food-E-Sthaan redefine your perception of dining.

                    Indulge. Savor. Connect. At Food-E-Sthaan, every meal is an event to remember.
                </p>
            </div>
        </center>
    </>);
}

export default About;