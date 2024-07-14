from flask import Flask, request, jsonify
from flask_cors import CORS
from PIL import Image
import io
import base64
import traceback
import cv2
import numpy as np
import random

app = Flask(__name__)
CORS(app)  # Allow CORS for all domains

def extract_average_color(image, x1, y1, x2, y2):
    """Extract the average color of the region specified by the coordinates."""
    region = image[y1:y2, x1:x2]
    avg_color = cv2.mean(region)[:3]  # Calculate average BGR color
    return avg_color

def determine_color_type(color):
    """Determine if the color is light, medium, or dark."""
    r, g, b = color
    if r > 200 and g > 180 and b > 150:
        return 'Light'
    elif r > 150 and g > 100 and b > 70:
        return 'Medium'
    else:
        return 'Dark'

def analyze_image(image):
    """Analyze the image to determine color palette, skin tone, hair color, and undertone."""
    open_cv_image = cv2.cvtColor(np.array(image), cv2.COLOR_RGB2BGR)
    height, width, _ = open_cv_image.shape

    # Define regions for skin tone, hair color, and undertone (example coordinates)
    skin_region = extract_average_color(open_cv_image, int(width * 0.4), int(height * 0.2), int(width * 0.6), int(height * 0.4))
    hair_region = extract_average_color(open_cv_image, int(width * 0.4), int(height * 0.0), int(width * 0.6), int(height * 0.2))
    undertone_region = extract_average_color(open_cv_image, int(width * 0.4), int(height * 0.4), int(width * 0.6), int(height * 0.6))

    skin_tone = determine_color_type(skin_region)
    hair_color = determine_color_type(hair_region)
    undertone = determine_color_type(undertone_region)

    # Placeholder palettes
    palettes = {
        'spring_warm': ['#FFB3B3', '#FFC680', '#FFFF80', '#BFFF80', '#80FFD4'],
        'summer_cool': ['#B3B3FF', '#B380FF', '#FF80FF', '#FF80B3', '#FFB3D4'],
        'autumn_warm': ['#FF8000', '#FFBF00', '#D4A017', '#8C6500', '#804000'],
        'winter_cool': ['#00BFFF', '#1E90FF', '#4169E1', '#5F9EA0', '#4682B4'],
    }
    chosen_palette_name = random.choice(list(palettes.keys()))
    chosen_palette = palettes[chosen_palette_name]

    return {
        'chosen_palette_name': chosen_palette_name,
        'chosen_palette': chosen_palette,
        'skin_tone': skin_tone,
        'hair_color': hair_color,
        'undertone': undertone
    }

@app.route('/analyze', methods=['POST'])
def analyze():
    try:
        data = request.json
        print("Received data:", data)  # Log the received data

        image_data = data['image']
        if ',' in image_data:
            image_data = image_data.split(',')[1]  # Remove the base64 header

        print("Image data after split:", image_data[:30])  # Log first 30 characters of the image data

        image = Image.open(io.BytesIO(base64.b64decode(image_data)))
        print("Image successfully opened.")

        # Perform image analysis
        result = analyze_image(image)

        return jsonify(result)
    except Exception as e:
        print("Error during image analysis:", traceback.format_exc())
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)
