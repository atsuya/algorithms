#include "vertex.h"

Vertex::Vertex(std::string name) { this->name_ = name; }

std::string Vertex::GetName() const { return this->name_; }
