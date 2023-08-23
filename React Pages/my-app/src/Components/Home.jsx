import '../myApp.css';

function Home() {
    return (<>
        <div className="container">
            <center>
                <div className="myHome">
                    
                    <h1>Welcome to FOOD-E-STHAAN</h1>
                    <p>Food-E-Sthaan is India's premier luxury hospitality brand with an ever-growing       presence across the country.
                        Known for our bespoke experiences and signature hospitality, we are ushering in new standards of opulence in the 4-star and 5-star hotel industry. We believe that a luxurious stay should indulge and satiate all the senses of an individual; resulting in an unforgettable experience. Want to test us out? Our curated stays are a testament to this fact.</p>
                </div>
            </center>
            <div id="carouselExampleFade" class="carousel slide carousel-fade">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="./img/rest1.jpg" class="d-block w-100" alt="..." />
                    </div>
                    <div class="carousel-item">
                        <img src="./img/rest2.jpg" class="d-block w-100" alt="..." />
                    </div>
                    <div class="carousel-item">
                        <img src="./img/rest3.jpg" class="d-block w-100" alt="..." />
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </>);
}

export default Home;